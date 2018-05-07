package repository;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import javafx.application.Platform;
import repository.config.ConfigReader;
import repository.responsehandlers.ResponseHandler;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private static String[] serverResponse;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Server response: " + msg);
        serverResponse = msg.toString().split(ConfigReader.getSeparator());
        String queryType = serverResponse[1];
        try {
            final String NEXT_FILES_INFO_QUERY = ConfigReader.getNextFilesInfoQuery();
            final String PREV_FILES_INFO_QUERY = ConfigReader.getPrevFilesInfoQuery();
            if (!(queryType.equals(NEXT_FILES_INFO_QUERY) || queryType.equals(PREV_FILES_INFO_QUERY))) {
                Platform.runLater(() -> {
                    ResponseHandler.exec(serverResponse);
                });
                ctx.close();
                ClientContainer.getChannel().close();
            } else {
                int numberOfFilesInfo = Integer.parseInt(serverResponse[3]);
                int currentFileInfoIndex = Integer.parseInt(serverResponse[4]);
                if (currentFileInfoIndex < numberOfFilesInfo - 1) {
                    ResponseHandler.exec(serverResponse);
                } else {
                    Platform.runLater(() -> {
                        ResponseHandler.exec(serverResponse);
                    });
                    ctx.close();
                    ClientContainer.getChannel().close();
                }
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
//        System.out.println("Client is active");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

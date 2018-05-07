package repository;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import repository.config.ConfigReader;

public class ClientContainer {
    private String host;
    private int port;
    private String toServerQuery;
    private static Channel channel;
    private ByteBuf delimiter;

    {
        byte[] EOT = {(byte) ConfigReader.getEndOfTransmission().charAt(0)};
        delimiter = Unpooled.copiedBuffer(EOT);
    }

    public ClientContainer(String host, int port, String toServerQuery) {
        this.host = host;
        this.port = port;
        this.toServerQuery = toServerQuery;
        start();
    }

    private void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap().group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast("framer", new DelimiterBasedFrameDecoder(
                                    1024, delimiter));
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("handler", new ClientHandler());
                        }
                    });
            channel = bootstrap.connect(host, port).sync().channel();
            channel.writeAndFlush(toServerQuery);
            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static Channel getChannel() {
        return channel;
    }
}

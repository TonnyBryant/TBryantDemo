package com.tbryant.customjedis;

public class CustomRedisClient {
    private CustomSocket redisSocket;

    public CustomRedisClient(String host, int port) {
        redisSocket = new CustomSocket(host, port);
    }

    public String set(String key, String value) {
        redisSocket.send(convertToCommand(Constant.command.SET, key.getBytes(), value.getBytes()));
        return redisSocket.read();
    }

    public String get(String key) {
        redisSocket.send(convertToCommand(Constant.command.GET, key.getBytes()));
        return redisSocket.read();
    }

    public String incr(String key) {
        redisSocket.send(convertToCommand(Constant.command.INCR, key.getBytes()));
        return redisSocket.read();
    }

    public static String convertToCommand(Constant.command command, byte[]... bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constant.START).append(bytes.length + 1).append(Constant.LINE);
        stringBuilder.append(Constant.LENGTH).append(command.toString().length()).append(Constant.LINE);
        stringBuilder.append(command.toString()).append(Constant.LINE);
        for (byte[] aByte : bytes) {
            stringBuilder.append(Constant.LENGTH).append(aByte.length).append(Constant.LINE);
            stringBuilder.append(new String(aByte)).append(Constant.LINE);
        }
        return stringBuilder.toString();
    }
}

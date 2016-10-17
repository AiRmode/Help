package com.provectus.prodobro.shared;


public enum StatusEnum {
    BANNED(-2),
    DELETED(-1),
    NOT_VERIFIED(0),
    ACTIVE(1);

    private int code;

    StatusEnum(int code) {
        this.code = code;
    }

//    public static Optional<StatusEnum> getStatusByCode(int code) {
    public static StatusEnum getStatusByCode(int code) {
        for (StatusEnum s : StatusEnum.values()) {
            if (s.code == code) {
//                return Optional.of(s);
                return s;
            }
        }
//        return Optional.empty();
        return null;
    }

    public int getCode() {
        return code;
    }
}

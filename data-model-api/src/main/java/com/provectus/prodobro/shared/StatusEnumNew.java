package com.provectus.prodobro.shared;


public enum StatusEnumNew {
    BANNED(-2),
    DELETED(-1),
    NOT_VERIFIED(0),
    ACTIVE(1);

    private int code;

    StatusEnumNew(int code) {
        this.code = code;
    }

//    public static Optional<StatusEnumNew> getStatusByCode(int code) {
    public static StatusEnumNew getStatusByCode(int code) {
        for (StatusEnumNew s : StatusEnumNew.values()) {
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

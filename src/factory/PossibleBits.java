package factory;

public enum PossibleBits {
    _40(40),
    _56(56),
    _80(80),
    _128(128),
    _168(168),
    _224(224),
    _256(256),
    _512(512),
    _1024(1024),
    _2048(2048),
    _4096(4096);

    private final int bits;

    PossibleBits(int bits) {
        this.bits = bits;
    }

    public int getValue() {
        return bits;
    }
}

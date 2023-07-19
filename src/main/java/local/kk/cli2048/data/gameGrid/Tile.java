package local.kk.cli2048.data.gameGrid;

public enum Tile implements ITile {

    ZERO(0) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_2;
        }
    },
    SCORE_2(2) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_4;
        }
    },
    SCORE_4(4) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_8;
        }
    },
    SCORE_8(8) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_16;
        }
    },
    SCORE_16(16) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_32;
        }
    },
    SCORE_32(32) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_64;
        }
    },
    SCORE_64(64) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_128;
        }
    },
    SCORE_128(128) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_256;
        }
    },
    SCORE_256(256) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_512;
        }
    },
    SCORE_512(512) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_1024;
        }
    },
    SCORE_1024(1024) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_2048;
        }
    },
    SCORE_2048(2048) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_4096;
        }
    },
    SCORE_4096(4096) {
        @Override
        public ITile upgrade() {
            return Tile.SCORE_8192;
        }
    },
    SCORE_8192(8192) {
        @Override
        public ITile upgrade() {
            throw new UndefineScoreRuntimeException();
        }
    };

    private int score;

    private Tile(int score) {
        this.score = score;
    }

    @Override
    public ITile clear() {
        return Tile.ZERO;
    }

    @Override
    public int getScore() {
        return this.score;
    }
}

class UndefineScoreRuntimeException extends RuntimeException {
    UndefineScoreRuntimeException() {
        super();
    }
}

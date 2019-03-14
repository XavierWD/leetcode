/**
 * Created by weixiaolong on 2019/2/14.
 */
public class ParkCar {
    private Car points[][];
    private int m;
    private int k;

    public ParkCar(int m, int k) {
        this.m = m;
        this.k = k;
        points = new Car[m][k];
    }


    public boolean park(Car car) throws Exception {
        XY xy = null;
        //摩托车
        if (car.getType() == 2) {
            xy = findMotor(car);
        }
        //汽车 或者 摩托车
        if (car.getType() == 2 || car.getType() == 1) {
            if (xy == null) {
                xy = findCar(car);
            }
        } else {
            throw new Exception("can't park the type car");
        }
        if (xy != null) {
            points[xy.x][xy.y] = car;
        }
        return xy != null;
    }


    public void unpark(Car car) throws Exception {
        int i = 0;
        int j = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < k; j++) {
                if (points[i][j] != null && points[i][j].van.equals(car.van)) {
                    points[i][j] = null;
                    return;
                }
            }
        }
        if (i == m && j == k) {
            throw new Exception("not found your car in parking");
        }
    }

    /**
     * 找汽车位
     *
     * @param c
     * @return
     */
    public XY findCar(Car c) {
        for (int i = 0; i < m; i++) {
            for (int j = k / 4; j < k; j++) {
                if (points[i][j] == null) {
                    return new XY(i, j);
                }
            }
        }
        return null;
    }

    public XY findMotor(Car c) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k / 4; j++) {
                if (points[i][j] == null) {
                    return new XY(i, j);
                }
            }
        }
        return null;
    }



    class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 2 为摩托车  1为汽车
     *
     * @return
     */
    static abstract class Car {
        private String van;

        private int type;

        public Car(String van) {
            this.van = van;
        }

        abstract int getType();


    }


    static class SmallCar extends Car {

        public SmallCar(String van) {
            super(van);
        }

        @Override
        public int getType() {
            return 1;
        }
    }

    static class MotorCar extends Car {

        public MotorCar(String van) {
            super(van);
        }

        @Override
        public int getType() {
            return 2;
        }


    }


    public static void main(String... args) throws Exception {
        ParkCar parkCar = new ParkCar(4, 4);
        Car motor = new MotorCar("K1122");
        boolean result = parkCar.park(motor);
        parkCar.unpark(motor);

    }
}

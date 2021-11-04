package course_work;


class Hole {
    private Ball ball;
    private int X, Y, Diametr;

    Hole(Ball ball){
        this.setBall(ball);
    }

    Hole(){	}

    void setX(int X){
        this.X = X;
    }

    int getX(){
        return this.X;
    }

    void setY(int Y){
        this.Y = Y;
    }

    int getY(){
        return this.Y;
    }

    void setDiametr(int Diametr){
        this.Diametr = Diametr;
    }

    int getDiametr(){
        return this.Diametr;
    }

    Ball getBall() {
        return ball;
    }

    void setBall(Ball ball) {
        this.ball = ball;
    }

    void ballMoveOut(){
        this.ball = null;
    }
}
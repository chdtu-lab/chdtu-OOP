package course_work;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.ArrayList;

public class MainWindow {
    private Shell shell;

    public static void main(String[] args) {
        try {
            MainWindow window = new MainWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private ArrayList<Hole> holes = new ArrayList<>();
    private void DrawHole(int D, int height, int index, Hole hole, GC gc){
        int start = 20;
        int x = index * (D) + index * start + start - 10;
        int ballD = D / 2;

        gc.drawOval(x, 5, D, D);
        if(hole != null){
            hole.setDiametr(D);
            hole.setX(x + D / 2);
            hole.setY(5 + D / 2);
            if(hole.getBall() != null){
                gc.setBackground(hole.getBall().getColor());
                gc.fillOval(x + ballD / 2, 5 + D / 2 - ballD / 2, ballD, ballD);
            }
        }
    }

    private int GetClickedHoleIndex(int X, int Y){
        int resultIndex = -1;
        for(Hole hole : holes){
            int x0 = hole.getX();
            int y0 = hole.getY();
            int r = hole.getDiametr() / 2;
            if(Math.sqrt((x0 - X) * (x0 - X) + (y0 - Y) * (y0 - Y)) <= r){
                resultIndex = holes.indexOf(hole);
                break;
            }
        }
        return resultIndex;
    }

    private int selectedHole;

    private int count;
    private void DoMove(int newSelection){

        if(newSelection != -1 && newSelection != selectedHole){
            if(holes.get(newSelection).getBall() == null) {
                if (Math.abs(newSelection - selectedHole) < 3) {
                    holes.get(newSelection).setBall(holes.get(selectedHole).getBall());
                    holes.get(selectedHole).ballMoveOut();
                    System.out.println("do move");
                    count += 1;
                    System.out.println(count);
                }
            }
        }	selectedHole = - 1;
    }

    private void createContents() {
        shell = new Shell();
        shell.setSize(517, 104);
        shell.setText("7 лунок");
        selectedHole = -1;
        Canvas canvas = new Canvas(shell, SWT.NONE);
        Device device = Display.getCurrent ();
        Color black = new Color (device, 0, 0, 0);
        Color white = new Color (device, 255, 255, 255);
        holes.add(new Hole(new Ball(black)));
        holes.add(new Hole(new Ball(black)));
        holes.add(new Hole(new Ball(black)));
        holes.add(new Hole());
        holes.add(new Hole(new Ball(white)));
        holes.add(new Hole(new Ball(white)));
        holes.add(new Hole(new Ball(white)));

        canvas.addPaintListener(e -> {
            int D = canvas.getBounds().width / 10;
            int height = canvas.getBounds().height;
            for(int i=0;i<7;i++){
                DrawHole(D, height, i, holes.get(i), e.gc);
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
                MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.CLOSE);
                messageBox.setText("Игра окончена");

                if(selectedHole == -1){
                    selectedHole = GetClickedHoleIndex(e.x, e.y);
                }
                else{
                    DoMove(GetClickedHoleIndex(e.x, e.y));
                    canvas.redraw();
                }

                if(holes.get(4).getBall() != null && holes.get(4).getBall().getColor() == black
                        && holes.get(5).getBall() != null && holes.get(5).getBall().getColor() == black &&
                        holes.get(6).getBall() != null && holes.get(6).getBall().getColor() == black) {
                    messageBox.setMessage("black is win with " + count + " steps");
                    messageBox.open();
                    holes.clear();
                    createContents();
                }
                if(holes.get(0).getBall() != null && holes.get(0).getBall().getColor() == white
                        && holes.get(1).getBall() != null && holes.get(1).getBall().getColor() == white &&
                        holes.get(2).getBall() != null && holes.get(2).getBall().getColor() == white) {
                    messageBox.setMessage("white is win with " + count + " steps");
                    messageBox.open();
                    holes.clear();
                    createContents();
                }
            }
        });
        canvas.setBounds(0, 0, 501, 64);
    }
}
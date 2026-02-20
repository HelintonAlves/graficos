package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    public static JFrame frame;
    private Thread thread;
    private boolean isRunning = true;
    private final int WIDTH = 240;
    private final int HEIGHT = 160;
    private final int SCALE = 3;
    private final BufferedImage image;
    private SpriteSheet sheet;
    private BufferedImage player;


    public Game(){
        sheet = new SpriteSheet("/spritesheet.png");
        player = sheet.getSprite(0, 0, 16, 16);
        setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        initFrame();
        image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
    }

    public void initFrame(){
        frame = new JFrame("Game #1");
        frame.add(this);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public synchronized void start(){
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    public synchronized void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick(){

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = image.getGraphics();
        //Backgroud
        g.setColor(new Color(0,98,0));
        g.fillRect(0,0,WIDTH, HEIGHT);
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image,0,0,WIDTH*SCALE,HEIGHT*SCALE,null);

        //Renderizando objetos na tela exemplo
        g.setColor(Color.RED);
        g.fillOval(0,0,40,40);

        //Renderizar textos na tela
        g.setFont(new Font("arial",Font.BOLD,20));
        g.drawString("Olá Mundo!", 80,30);

        //Renderizando o player
        g.drawImage(player, 30, 60,null);



        bs.show();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while (isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1){
                tick();
                render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000){
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }

        }
        stop();
    }
}

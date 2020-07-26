package animasyon;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SuruklenebilirTus extends JButton{
    private Point dokunulanYer;
    private final Cursor suruklemeFareKursoru=Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    
    public SuruklenebilirTus(int x,int y,int genislik,int yukseklik)
    {
        setSize(genislik, yukseklik);
        setLocation(x, y);
        setIcon(new ImageIcon(SuruklenebilirTus.class.getResource("/resim/araba.png")));
        setBorderPainted(false);
        setOpaque(false);
        setContentAreaFilled(false);
        suruklemeOlaylariniEkle();
    
    }
    private void suruklemeOlaylariniEkle()
    {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                dokunulanYer=e.getPoint();
                setCursor(suruklemeFareKursoru);
                
                  }

            @Override
            public void mouseDragged(MouseEvent e) {
                
                Point ekrandakiYer=getParent().getLocationOnScreen();
                Point fareninEkrandakiYeri=e.getLocationOnScreen();
                Point yeniYer=new Point(fareninEkrandakiYeri.x-ekrandakiYer.x-dokunulanYer.x,
                                        fareninEkrandakiYeri.y-ekrandakiYer.y-dokunulanYer.y);
                setLocation(yeniYer);
                   }
            
            
});    
    }
    
    
    
}

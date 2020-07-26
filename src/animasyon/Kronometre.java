package animasyon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Kronometre {

    private final SaatDinleyici saat = new SaatDinleyici();
    private Timer zamanlayici = null;
    private final JComponent bilesen;
    private Date baslangic;
    private final SimpleDateFormat tarihFormat = new SimpleDateFormat("HH:mm:ss");
    private final JLabel saatLabel;

    public Kronometre(int sure, JComponent bilesen, JLabel saatLabel) {
        this.bilesen = bilesen;
        this.saatLabel = saatLabel;
        zamanlayici = new Timer(sure, this.saat);
        zamanlayici.setInitialDelay(0);
        tarihFormat.setTimeZone(TimeZone.getTimeZone("UTC+2"));

    }

    public void baslat() {
        baslangic = new Date();
        zamanlayici.start();
    }

    public void durdur() {
        zamanlayici.stop();
    }

    public void guncelle() {
        Date simdi = new Date();
        if (bilesen.getLocation().getX() >= bilesen.getParent().getSize().getWidth()) {
            bilesen.setLocation(0, bilesen.getLocation().x);
        }
        bilesen.setLocation(bilesen.getLocation().x + 1, bilesen.getLocation().y);
        saatLabel.setText(tarihFormat.format(new Date(simdi.getTime() - baslangic.getTime())));

    }

    private class SaatDinleyici implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            guncelle();
        }

    }
}

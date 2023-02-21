public class SecondB {
    public static void main(String[] args) {
        String[] mahalleAdlari = {"Özkanlar","Evka 3","Atatürk","Erzene","Kazımdirik","Mevlana","Doğanlar","Ergene"};

        int[] siparisler = {5,2,7,2,7,3,0,1};

        KuyrukM q = new KuyrukM(mahalleAdlari.length); // Queue'nin oluşturulması

        for(int i = 0;i< mahalleAdlari.length;i++){  // Mahalle objelerinin oluşturulması queueye eklenmesi
            q.ekle(new Mahalle(siparisler[i],mahalleAdlari[i]));
        }

        while(!q.bosMu()){  // Bilgilerin yazdırılması
            Mahalle mahalle = q.cikar();
            System.out.println("Mahalle Adı: "+mahalle.mahalleAdi);
            System.out.println("Teslimat Bilgileri: ");
            for(int i = 0;i<mahalle.teslimatlar.size();i++){
                System.out.println(mahalle.teslimatlar.get(i).yemek+" "+mahalle.teslimatlar.get(i).adet);
            }
            System.out.println();
        }
    }
}

class KuyrukM {  // Kuyruk objesinin oluşturulması
    private int boyut;
    private Mahalle[] kuyrukDizi;
    private int bas;
    private int son;
    private int elemanSayisi;

    // Yapılandırıcı Metot (Constructor)
    public KuyrukM(int s) {
        boyut = s;
        kuyrukDizi = new Mahalle[boyut];
        bas = 0;
        son = -1;
        elemanSayisi = 0;
    }

    public void ekle(Mahalle j) { // Kuyruk için ekleme metodunun yazılması
        if (son == boyut - 1) son = -1;
        kuyrukDizi[++son] = j;
        elemanSayisi++;
    }

    public Mahalle cikar() {  // Kuyruk için çıkarma metodu
        Mahalle temp = kuyrukDizi[bas++];
        if (bas == boyut) bas = 0;
        elemanSayisi--;
        return temp;
    }

    public boolean bosMu() {
        return (elemanSayisi == 0);
    }
}

public class Fourth {
    public static void main(String[] args) {

        int[] musteriler = {6,7,2,1,12,5,3,7,4,2}; // Süre için tamsayılar dizisi

        int toplam = 0;  // Toplam geçen süre

        Kuyruk kuyruk = new Kuyruk(musteriler.length); // Kuyruk objesinin oluşturulması

        for (int j : musteriler) { // Müşterilerin kuyruğa eklenmesi
            kuyruk.ekle(j);
        }

        for(int i = 0;i<musteriler.length;i++){ // Toplam sürenin hesaplanması ve bilgierin yazdırılması
            int sure = kuyruk.cikar()*3;
            System.out.println((i+1)+". Müsterinin Süresi: "+ sure);
            System.out.println();
            toplam += sure;
        }

        System.out.println("Bu kasa için geçen ortalam süre: "+ toplam/musteriler.length);
    }
}


class Kuyruk {  // Kuyruk objesinin oluşturulması
    private int boyut;
    private int[] kuyrukDizi;
    private int bas;
    private int son;
    private int elemanSayisi;

    // Yapılandırıcı Metot (Constructor)
    public Kuyruk(int s) {
        boyut = s;
        kuyrukDizi = new int[boyut];
        bas = 0;
        son = -1;
        elemanSayisi = 0;
    }

    public void ekle(int j) { // Kuyruk için ekleme metodunun yazılması
        if (son == boyut - 1) son = -1;
        kuyrukDizi[++son] = j;
        elemanSayisi++;
    }

    public int cikar() {  // Kuyruk için çıkarma metodu
        int temp = kuyrukDizi[bas++];
        if (bas == boyut) bas = 0;
        elemanSayisi--;
        return temp;
    }

    public boolean bosMu() {
        return (elemanSayisi == 0);
    }
}

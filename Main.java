package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner tara=new Scanner(System.in);
    private static CepTelefonu cepTelefonu=new CepTelefonu("555 555 55 55");

    public static void main(String[] args) {





        telefonuBaslat();
        menuyuGoster();
        boolean cikis=false;

        while (!cikis){
            System.out.println("Menüyü Görmek İçin 6'yı Tuşlayınız");
            int secim=tara.nextInt();

            switch (secim){
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    cikis=true;
                    break;
                case 1:
                    cepTelefonu.tumRehber();
                    break;
                case 2:
                    yeniKisiEkleMethodu();
                    break;
                case 3:
                    kisiSorgulaMethodu();
                    break;
                case 4:
                    kisiSilMethodu();
                    break;
                case 5:
                    kisiGuncellemeMethodu();
                    break;



                case 6:
                    menuyuGoster();
                    break;

                    default:
                        System.out.println("Lütfen 1 ile 6 arasında bir sayı giriniz!!!");
            }
        }

    }

    private static void kisiGuncellemeMethodu() {
        System.out.println("Güncellenecek kişinin adı:");
        String isim=tara.next();

        Kisi bulunanKisi=cepTelefonu.kisiSorgula(isim);
        if (bulunanKisi==null){
            System.out.println("Kayıt bulunamadı");
            return;
        }
        System.out.println("Yeni isim değeri:");
        String yeniIsim=tara.next();
        System.out.println("Yeni telefon numarası");
        String yeniTelefonNo=tara.next();

        cepTelefonu.kisiGuncelle(bulunanKisi, Kisi.olustur(yeniIsim,yeniTelefonNo));


    }

    private static void kisiSilMethodu() {
        System.out.println("Silinecek kişinin adı:");
        String isim=tara.next();
        Kisi bulunanKisi=cepTelefonu.kisiSorgula(isim);
        if(cepTelefonu.kisiSil(bulunanKisi)){
            System.out.println("Silme işlemi yapıldı");
        }

    }

    private static void kisiSorgulaMethodu() {
        System.out.println("Aranacak kişi adını giriniz");
        String isim=tara.next();

        Kisi bulunanKisi=cepTelefonu.kisiSorgula(isim);
        if (bulunanKisi==null){
            System.out.println(isim+"İsminde bir kayıt bulunamadı");
        }
        System.out.println("Bulunan kişi : "+bulunanKisi.getIsim()+" -> "+bulunanKisi.getTelNo());
    }

    private static void yeniKisiEkleMethodu() {
        System.out.println("Yeni Kişinin Adı: ");
        String isim=tara.next();
        System.out.println("Yeni Kişinin Telefonu: ");
        String telefon=tara.next();


        cepTelefonu.ekleYeniKisi(Kisi.olustur(isim,telefon));

    }

    private static void telefonuBaslat() {
        System.out.println("Telefon Başlatılıyor...");
    }

    private static void menuyuGoster() {
        System.out.println("**************** MENU ****************");
        System.out.println("0 -- Çıkış\n" +
                "1 -- Tüm Kişileri Listele\n" +
                "2 -- Yeni Kişi Ekle\n" +
                "3 -- Kişi Sorgula\n" +
                "4 -- Kişi Sil\n" +
                "5 -- Kişi Güncelle\n" +
                "6 -- Menüyü Göster");
    }
}

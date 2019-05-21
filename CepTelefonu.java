package com.company;

import java.util.ArrayList;

public class CepTelefonu {

    private ArrayList<Kisi> rehber;
    private String kendiNumaram;

    public CepTelefonu(String kendiNumaram){
        this.kendiNumaram = kendiNumaram;
        this.rehber=new ArrayList<>();
    }

    public boolean ekleYeniKisi(Kisi yeniKisi){
        if (kisiBul(yeniKisi.getIsim()) >= 0){
            System.out.println(yeniKisi.getIsim()+"değeri rehberde zaten var");
            return false;
        }

        this.rehber.add(yeniKisi);
        return true;
    }

    public int kisiBul(Kisi aranacakKisi){
        return this.rehber.indexOf(aranacakKisi);
    }

    public int kisiBul(String isim){

        for(int i=0;i<this.rehber.size();i++){
            Kisi oankiKisiNesnesi=this.rehber.get(i);
            if (oankiKisiNesnesi.getIsim().equals(isim)){
                return i;
            }
        }
        return -1;
    }

    public Kisi kisiSorgula(String isim){
        int position=kisiBul(isim);
        if (position >= 0){
            return rehber.get(position);
        }
        return null;
    }

    public boolean kisiSil(Kisi silinecekKisi){

        int position= kisiBul(silinecekKisi);
        if (position <0 ){
            System.out.println("Böyle bir kişi yok");
        }
        this.rehber.remove(silinecekKisi);
        return true;
    }

    public boolean kisiGuncelle(Kisi eskiKisi, Kisi yeniKisi){
        int bulunanPosition=kisiBul(eskiKisi);
        if(bulunanPosition <0 ){
            System.out.println("Böyle bir kayıt yok");
            return false;
        }
        rehber.set(bulunanPosition, yeniKisi);
        System.out.println(eskiKisi.getIsim()+" değeri "+yeniKisi.getIsim()+" ile güncellendi ");
        return true;
    }

    public void tumRehber(){

        System.out.println("\n********* TÜM REHBER *********");
        if (rehber.size() ==0 ){
            System.out.println("Kayıtlı Kişi Yok\n\n");
            return;
        }
        for(int i=0; i<this.rehber.size(); i++){
            System.out.println((i+1)+"-"+rehber.get(i).getIsim()+" -> "+rehber.get(i).getTelNo());
        }
    }

}

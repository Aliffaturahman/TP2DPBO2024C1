/*
    Saya Alif Faturahman Firdaus (2107377) mengerjakan Tugas Praktikum 2 dalam mata
    kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang
    telah dispesifikasikan. Aamiin.
*/

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String hobby;
    private String mbti;

    public Mahasiswa(String nim, String nama, String jenisKelamin, String hobby, String mbti) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.hobby = hobby;
        this.mbti = mbti;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setMBTI(String mbti) {
        this.mbti = mbti;
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenisKelamin() {
        return this.jenisKelamin;
    }

    public String getHobby() {
        return this.hobby;
    }

    public String getMBTI() { return this.mbti; }
}

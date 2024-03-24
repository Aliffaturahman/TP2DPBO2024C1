# TP2DPBO2024C1

## JANJI
*Saya Alif Faturahman Firdaus (2107377) mengerjakan Tugas Praktikum 2 dalam mata kuliah DPBO untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.*

## TUGAS
Lanjutkan program LP5 yang sudah kamu buat, lalu tambahkan koneksi dengan database MySQL. Ubah program dengan spesifikasi sebagai berikut:
1. Hubungkan semua proses CRUD dengan database.
2. Tampilkan dialog/prompt error jika masih ada input yang kosong saat insert/update.
3. Tampilkan dialog/prompt error jika sudah ada NIM yang sama saat insert.

## DESAIN PROGRAM
Program ini teridiri dari 3 kelas :

### A. Class Mahasiswa  
Kelas ini adalah kelas untuk membuat objek mahasiswa yang didalamnya terdapat 5 atribut, diantaranya nim (string), nama (string), jenisKelamin (string), hobby (string) dan mbti (string). Terdapat juga setter dan getter untuk setiap atributnya.

### B. Class Menu  
Kelas ini berisikan method-method untuk menampilkan tampilan dan juga terdapat fitur-fitur yang memiliki fungsi beragam didalam program, diantaranya :
1. Menu -> method yang berfungsi sebagai pilar utama dari jalan kerja program
2. setTable -> method yang berfungsi untuk membuat table
3. insertData -> method yang berfungsi untuk menambahkan mahasiswa data pada tabel
4. checkNIMDatabase -> method yang berfungsi untuk mengecek apakah NIM sudah ada di database
5. updateData -> method yang berfungsi untuk mengubah data yang tersedia pada tabel
6. deleteData -> method yang berfungsi untuk menghapus satu baris data dari tabel
7. clearForm -> method yang berfungsi untuk menghapus data pada form tabel menjadi kosong kembali

### C. Class Database  
Kelas ini adalah kelas untuk membuat sistem CRUD databse yang didalamnya terdapat 3 method, diantaranya 
1. Database -> method yang berfungsi sebagai constructor
2. ResultSet -> method yang berfungsi untuk SELECT
3. insertUpdateDeleteQuery -> method yang berfungsi untuk INSERT, UPDATE, dan DELETE data

### * Desain Database Mahasiswa
![image](https://github.com/Aliffaturahman/TP2DPBO2024C1/assets/100842759/d5152a79-7a07-470b-add0-9654dd3c5694)

## PENJELASAN ALUR
* Untuk judul "Daftar Mahasiswa" dan owner "*By Alif Faturahman Firdaus*" menggunakan swing controls JLabel, kemudian untuk "NIM", "Nama", "Jenis Kelamin", "Hobby", dan "MBTI" juga menggunakan swing controls JLabel. 
* Pada kolom "nim", "nama", dan "hobby" menggunakan swing controls JTextField. 
* Terdapat juga dropdown menu pada kolom "jenisKelamin" dan "mbti" yang menggunakan swing controls JCompoBox. 
* Pada tombol "add", "update", "cancel", "delete" menggunakan swing controls JButton. 
* Kemudian yang terakhir yaitu tabel, menggunakan swing controls JTable.

Terdapat method Menu yang berfungsi untuk melakukan pengisian tabel dengan list mahasiswa kedalam database, dapat juga melakukan styling font seperti pada Label judul dan owner. Untuk isi dari list pada dropdown menu yang terdapat pada CompoBox juga setiap elemenya di isi melalui method Menu yangmana kita dapat mengisi atau menambahkan elemen sesuai keinginan. Kemudian berisikan juga listener untuk berbagai fungsi seperti "addUpdateButton", "deleteButton", "cancelButton", dan "mahasiswaTable".

## DOKUMENTASI
Melakukan penambahan data dengan beberapa kolom tidak terisi sehingga memunculkan prompt error, kemudian dilanjut dengan mengisi seluruh kolom dengan data yang baru, lalu setelah klik **ADD** maka muncul pesan dialog bahwa data berhasil ditambahkan dan data tersebut akan langsung masuk kedalam database (untuk memeriksanya lakukan resfresh pada halaman *phpmyadmin* maka data baru akan langsung muncul). Setelah menambah data dilanjutkan dengan mengubah data, pilih data yang akan diubah kemudian ubah data yang lama dengan data yang baru, jika semua kolom tidak di isi dengan data yang baru, maka akan menampilkan prompt error, tetapi jika sudah mengisi semua kolom kemudian menekan tombol **UPDATE**, alhasil akan menampilkan pesan dialog bahwa data berhasil diubah (lakukan refresh lagi untuk melihat perubahan data pada halaman *phpmyadmin*). Terakhir, melakukan penghapusan data dengan memilih data mana yang ingin dihapus kemudian tekan tombol **DELETE**, maka data akan terhapus dari daftar tabel (lakukan refresh kembali untuk melihat data yang dipilih sudah tidak ada yang menandakan bahwa data tersebut sudah berhasil dihapus dari database)

Berikut ini adalah video demo dari programnya.  

**_( besarkan volume untuk mendengarkan penjelasan demo video )_**

https://github.com/Aliffaturahman/TP2DPBO2024C1/assets/100842759/5522351a-258b-4f12-b468-603eb56fb05c



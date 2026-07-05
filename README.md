# KMS Putusan Pengadilan Narkotika

## Deskripsi Proyek
Aplikasi Knowledge Management System (KMS) berbasis Java dengan arsitektur 
MVC (Model-View-Controller) untuk mengelola data putusan pengadilan pidana 
narkotika. Aplikasi ini mengolah dataset putusan pengadilan narkotika dari 
berbagai Pengadilan Negeri di Indonesia.

## Arsitektur
- **Model** : Putusan, KnowledgeRepository, StatistikPutusan
- **View** : ConsoleView
- **Controller** : KnowledgeController, InputHandler

## Cara Kompilasi
```bash
javac -encoding UTF-8 -d out src/app/Main.java src/controller/KnowledgeController.java src/model/Putusan.java src/model/KnowledgeRepository.java src/model/StatistikPutusan.java src/util/InputHandler.java src/view/ConsoleView.java
```

## Cara Menjalankan
```bash
java -cp out app.Main
```

## Fitur
- Tambah data putusan baru
- Lihat semua putusan
- Cari putusan by nomor/nama
- Filter putusan by jenis narkotika/pengadilan
- Tampilkan statistik
- Hapus putusan

## Video Demo
https://youtu.be/70yaKqAQL-o

## Anggota Kelompok
| Nama | NIM | Kelas | Peran | Branch |
|------|-----|-------|-------|--------|
| Faiq Akhmad Aysar | 202510370110088 | A | Backend Developer / Controller | feature/controller |
| muhammad razan daffa majid | 202510370110021 | B | GUI Designer / View | feature/view |
| Selma kadir pelu | 202310370311297 | B | Knowledge Engineer / Model | feature/model |

Ýlk önce wordvec dosyasýnda tüm kelimeleri kullanarak ve hepsini birbirine baðlayarak undirected graph oluþturdum.Daha sonra 
wordpair dosyasýndaki kelimeleri kullanarak ve yine hepsini birbirine baðlayarak weighted undirected graph oluþturdum.Uzunluklarý wordvec 
dosyasýndaki ilgili kelimenin sayýlarý kullandým ve cosinus similarity hesaplayarak uzunluðu hesapladým, negatif çýkanlarý 1 ile toplayarak
pozitif yaptým.Daha sonra bu grapha ait minimum spanning tree buldum.Daha sonra argument olarak verilen küme sayýsýnýn bir eksiði kadar en kýsa 
uzunluklu vertexi silip kalanlarý output olarak yazdýrdým.Yolladýðým output için küme sayýsý 3 olarak alýndý.
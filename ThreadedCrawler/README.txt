Napisati aplikaciju koja će da iz liste urls (String[], ArrayList, … ili iz fajla) da čita adrese stranica (url) i šalje ih na crawling mehanizam (pojašnjen na predavanjima).

Crawling mehanizam treba da dobavi sardžaj stranice i snimi ga u file sa random generisanim imenom.

Sam proces crawlinga se izvršava u threadovima, a broj threadova je jednak broju url-ova u listi.

Svi threadovi, nakon završenog upisivanja u fajl, otvaraju zajednički fajl crawling_diaries.txt, koji je definisan kao File(putanja/do/crawling_diaries.txt) i u novu liniju pišu koju adresu su i kada crawlali.

Potrebno je imati na umu činjenicu da je crawling_diaries.txt dijeljeni resurs i potrebno je da mehanizam upisa u taj fajl bude thread safe. (synchronise)

Pored upisa u crawling_diaries, potrebno je i da svaki thread ispiše “globalnu” varijablu int pagesCrawled, koju svaki thread povećava za 1.

int pagesCrawled se nalazi u Crawler klasi, kao i File crawlingDiaries.

PARAMETRI: outputDirectory: /tmp/crawled/ outputFileName: random_generisano_ime.txt 5 < urls < 10

NAPOMENA: outputDirectory nije prethodno kreiran i potrebno je izvršiti provjeru, da li postoji. Ako ne postoji, potrebno ga je kreirati (kroz kod). (Pogledati predavanja za primjer)
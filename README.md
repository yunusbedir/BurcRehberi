# BurcRehberi

## ArrayAdapter
ListView a Dizilerimizi aktarmak için kullandığımız araçtır.
Dizideki veriyi alıp ListView için seçtiğimiz item türüne dönüştürüyor.
Ardından ListView.adapeter ile oluşturduğumuz adapterı set ediyoruz.
ÖRNEK :

'''
    var burclar = arrayOf("Koç","Boğa","İkizler","Yengeç","Aslan")
    //ArrayAdapter oluşturuyoruz.Bu sınıfın 'contexti' içerisinde 'simple_list_item_1' türünde 'burclar' dizisini ArrayAdaptere dönüştürüyoruz
    var burclarAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,burclar)
    //simple_list_item dışında farklı ListView item viewleri bulunmaktadır.
    //burclarAdapter ımızı list_burclar listView ımıza set ediyoruz
    list_burclar.adapter = burclarAdapter
'''
    
## Toolbar için Yardım Alınan Sayfa 
https://blog.iamsuleiman.com/toolbar-animation-with-android-design-support-library/
Animasyonlu Toolbar oluşturmak için kullanıldı

## Palette API :
Dynamic Colors with Palette API ;
    Bununla beraber Toolbar'ındaki baskın rengi bulup ona göre colorPrimary , colorPrimaryDark ları değiştirmemize yarıyacaktır.
    Aynı link üzerinde ayrıntılı bilgi bulunmakta.
        
## Giriş sayfası arkada baloncuk oluşturma animasyon :
https://android-arsenal.com/details/1/5519
Burada ki kütüphane kullanıldı  
Ilk önce kütüphaneler eklendi
### build.gradle(Project:BurcRehberi)
'''
allprojects {
    repositories {
        google()
        jcenter()
        maven{
            url "http://dl.bintray.com/glomadrian/maven"
        }
    }
} 
'''
### build.gradle(Module: app)
'''
    implementation 'com.github.glomadrian:Grav:1.1'
'''
   
         
      

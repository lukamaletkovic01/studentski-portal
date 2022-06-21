var indeks = "57/2018"

function IspisiPredmet(rednibroj){
    window.location.replace("http://localhost:8080/StudentPregledPredmeti/IspisiPredmeti?indeks="+indeks+"&sifraPredmeta="+nizsifra[rednibroj].innerHTML);
}
function UpisiPredmet(rednibroj){

    window.location.replace("http://localhost:8080/StudentPredmeti/UpisiPredmet?indeks="+indeks+"&sifraPredmeta="+nizsifra[rednibroj].innerHTML);

}
function PrijaviPredmet(rednibroj){
    if (confirm('Jeste li sigurni da zelite da prijavite predmet?'))
        window.location.replace("http://localhost:8080/StudentPrijava/PrijaviIspit?sifraPredmeta="+nizsifra[rednibroj].innerHTML 
        +"&ispitniRok="+nizispitni[rednibroj].innerHTML+"&datumPolaganja="+nizdatumpolaganja[rednibroj].innerHTML+"&ocena="+0+
        "&imeProfesora="+nizimep[rednibroj].innerHTML+"&prezimeProfesora="+nizprezimep[rednibroj].innerHTML+"&skolskaGodina="+
        nizskolskagodina[rednibroj].innerHTML+"&indeks="+indeks+"&naziv="+niznazivpredmeta[rednibroj].innerHTML);

}
var nizispitni, nizdatumpolaganja, nizskolskagodina, nizdatumzatvaranja
function loadPredmeti2(){

    nizimep = document.getElementsByClassName("TimeP");
    nizprezimep = document.getElementsByClassName("TprezimeP");
    nizsifra = document.getElementsByClassName("TsifraPredmeta");
    niznazivpredmeta = document.getElementsByClassName("TnazivPredmeta");
    niztippredmeta = document.getElementsByClassName("TtipPredmeta");
    nizespb = document.getElementsByClassName("TeSPB");
    nizsemestar = document.getElementsByClassName("Tsemestar");
    nizispitni = document.getElementsByClassName("TispitniRok");
    nizdatumpolaganja = document.getElementsByClassName("TdatumPolaganja");
    nizskolskagodina = document.getElementsByClassName("TskolskaGodina");
    nizdatumzatvaranja = document.getElementsByClassName("TdatumZatvaranja");

    nizupisi = document.getElementsByClassName("upisiMe");
    nizispisi = document.getElementsByClassName("ispisiMe");
    nizprijavi = document.getElementsByClassName("PrijaviMe");

    if (nizupisi.length && nizupisi){
       
        for(i=0; i < nizimep.length; i++)
        {
            nizupisi[i].innerHTML="<input value='UPISI ME' type='button' onclick='UpisiPredmet(\""+i+"\")'>";            
        }   
    }
    else if(nizprijavi.length && nizprijavi){
        
        for(i=0; i < nizimep.length; i++)
        {
         nizprijavi[i].innerHTML="<input value='PRIJAVI ME' type='button' onclick='PrijaviPredmet(\""+i+"\")'>";        
        }
    }
    else{
        for(i=0; i < nizimep.length; i++)
        {
        nizispisi[i].innerHTML="<input value='ISPISI ME' type='button' onclick='IspisiPredmet(\""+i+"\")'>";
        }
    }
    
}

function proveriImaLiIspita(){

    nizispiti = document.getElementsByClassName("sifraispita");
    nizispitni = document.getElementsByClassName("TispitniRok");
    if(!(nizispiti.length && nizispiti)){
        if (!(nizispitni.length && nizispitni)){
            t = document.getElementById("tabela");
            t.innerHTML="<tr><td><b>NEMA ISPITA<b></td></tr>";
        }
    }

}
function popuniOcene(){
    
    nizocena = document.getElementsByClassName("ocena");
    
    for (i = 0; i < nizocena.length; i++){
        if (nizocena[i].innerHTML === "0"){
            nizocena[i].innerHTML = "-";
        }
    }
}
function proveriImaLiPredmeta(){

    nizpredmeti = document.getElementsByClassName("TsifraPredmeta");
    
    if(!(nizpredmeti.length && nizpredmeti)){
        t = document.getElementById("tabela");
        t.innerHTML="<tr><td><b>NEMA PREDMETA<b></td></tr>";
    }
}
function kombofilter() {
    predmetobj = document.getElementById("predmet");
    rokobj = document.getElementById("rok");
    godinaobj = document.getElementById("godina");
    filterr = document.getElementById("pretraga").value.toUpperCase();

    opcija1 = predmetobj.options[predmetobj.selectedIndex].text.toUpperCase();
    opcija2 = rokobj.options[rokobj.selectedIndex].text.toUpperCase();
    opcija3 = godinaobj.options[godinaobj.selectedIndex].text.toUpperCase();

    tr = document.getElementsByTagName("tr");

    for (i = 0; i < tr.length; i++) {
        td1 = tr[i].getElementsByTagName("td")[3];
        td2 = tr[i].getElementsByTagName("td")[4];
        td3 = tr[i].getElementsByTagName("td")[8];
        if (td1 && td2 && td3) {
            txtValue1 = td1.textContent || td1.innerText;
            txtValue2 = td2.textContent || td2.innerText;
            txtValue3 = td3.textContent || td3.innerText;
            if (txtValue1.toUpperCase().indexOf(opcija1) > -1 && txtValue2.toUpperCase().indexOf(opcija2) > -1 && txtValue3.toUpperCase().indexOf(opcija3) > -1) {
                td4 = tr[i].getElementsByTagName("td")[0];
                td5 = tr[i].getElementsByTagName("td")[1];
                if (td4 && td5) {
                    txtValue4 = td4.textContent || td4.innerText;
                    txtValue5 = td5.textContent || td5.innerText;
                    if (txtValue4.toUpperCase().indexOf(filterr) > -1 || txtValue5.toUpperCase().indexOf(filterr) > -1) {
                        tr[i].style.display = "";
                    }
                    else {
                        tr[i].style.display = "none";
                    }
                }    
            }
            else {
                tr[i].style.display = "none";
            }
            
        }
    }
    obojiVrste();
}
var datumPolaganja, ispitniRok, sifraPredmeta, datumOtvaranja, datumZatvaranja, nazivPredmeta;

function loadIPopuni(){

    danas = new Date();
    dd = String(danas.getDate()).padStart(2, '0');
    mm = String(danas.getMonth() + 1).padStart(2, '0'); 
    yyyy = danas.getFullYear();
    t = document.getElementsByClassName("TdatumOtvaranjaPrijave");
    for (i = 0 ; i < t.length ; i++){
        t[i].innerHTML = mm + '/' + dd + '/' + yyyy;
    }

    sifraPredmeta = document.getElementsByClassName("TsifraPredmeta");
    nazivPredmeta = document.getElementsByClassName("TnazivPredmeta");
    ispitniRok = document.getElementsByClassName("OIspitniRok");
    datumOtvaranja = document.getElementsByClassName("TdatumOtvaranjaPrijave");
    datumZatvaranja = document.getElementsByClassName("OdatumZatvaranjaPrijave");
    datumPolaganja = document.getElementsByClassName("OdatumPolaganja");

    dugme = document.getElementsByClassName("potvrdi");
    for (i = 0; i < sifraPredmeta.length; i++){
        dugme[i].innerHTML = "<input value='OTVORI PRIJAVU' type='button' onclick='otvoriPrijavu(\""+i+"\")'>"
    }

}

function otvoriPrijavu(rednibroj){
    
    if (datumZatvaranja[rednibroj] && datumZatvaranja[rednibroj].value && datumPolaganja[rednibroj] && datumPolaganja[rednibroj].value){
        danas = new Date();
        
        nizmdg1 = datumOtvaranja[rednibroj].innerHTML.split("/");
        datOtv = nizmdg1[2] + "-" + nizmdg1[0] + "-" + nizmdg1[1]; 
        if (confirm('Jeste li sigurni da zelite da otvorite prijavu?'))
            window.location.replace("http://localhost:8080/profesorPrijave/OtvoriPrijavu?datumPolaganja="+datumPolaganja[rednibroj].value
            +"&ispitniRok="+ispitniRok[rednibroj].value+"&sifraPredmeta="+sifraPredmeta[rednibroj].innerHTML+"&skolskaGodina="+danas.getFullYear()
            +"&datumOtvaranja="+datOtv+"&datumZatvaranja="+datumZatvaranja[rednibroj].value);
    }
    else{
        alert("Popunite sva polja")
    }
}

var indeks, sifraPredmeta, ispitniRok, ocena, skolskaGodina;

function loadIspiti(){

    indeks = document.getElementsByClassName("indeks");
    sifraPredmeta = document.getElementsByClassName("sifraPredmeta");
    ispitniRok = document.getElementsByClassName("ispitniRok");
    ocena = document.getElementsByClassName("ocena");
    skolskaGodina = document.getElementsByClassName("skolskaGodina");
    potvrdiOcenu = document.getElementsByClassName("potvrdiOcenu");

    for (i = 0; i < indeks.length; i++){
        potvrdiOcenu[i].innerHTML = "<input type='button' value='POTVRDI OCENU' onclick='RpotvrdiOcenu(\""+i+"\")'>";
    }                                                                                   

}
function RpotvrdiOcenu(rednibroj){
    if (confirm('Jeste li sigurni da zelite da upisete ocenu?'))
        window.location.replace("http://localhost:8080/profesorUpisiPregled/UpisOcene?sifraPredmeta="+sifraPredmeta[rednibroj].innerHTML+
        "&ispitniRok="+ispitniRok[rednibroj].innerHTML+"&ocena="+ocena[rednibroj].value+"&skolskaGodina="+skolskaGodina[rednibroj].innerHTML+"&indeks="+indeks[rednibroj].innerHTML);

}

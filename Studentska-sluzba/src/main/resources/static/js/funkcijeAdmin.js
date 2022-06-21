
var nizindex,nizemail,nizime,nizimeoca,nizprezime,nizjmbg,nizstatus,nizupisansemestar,nizstudije,niznazivsmera;
var nizimep,nizprezimep,nizsifra,niznazivpredmeta,niztippredmeta,nizespb,nizsemestar;
var nizidprofesora,nizimeprofesora,nizprezimeprofesora,nizemailprofesora,nizjmbgprofesora;
function loadStudenti(){

    nizindex = document.getElementsByClassName("index");
    nizime = document.getElementsByClassName("Time");
    nizprezime = document.getElementsByClassName("Tprezime");
    nizstatus = document.getElementsByClassName("Tstatus");
    nizimeoca = document.getElementsByClassName("TimeOca");
    nizstudije = document.getElementsByClassName("Tstudije");
    nizupisansemestar = document.getElementsByClassName("TupisanSemestar");
    niznazivsmera = document.getElementsByClassName("TnazivSmera");
    nizjmbg = document.getElementsByClassName("Tjmbg");
    nizemail = document.getElementsByClassName("Temail");

    nizobrisi = document.getElementsByClassName("obrisi");
    nizizmeni = document.getElementsByClassName("izmeni");

    for(i=0; i < nizindex.length; i++)
    {
        nizobrisi[i].innerHTML="<input type='button' value='Obrisi' onclick='obrisiStudent(\""+i+"\")'>";
        nizizmeni[i].innerHTML="<input type='button' value='Izmeni' onclick='popuniStudent(\""+i+"\")'>";
    }
}
function loadPredmeti(){

    nizimep = document.getElementsByClassName("TimeP");
    nizprezimep = document.getElementsByClassName("TprezimeP");
    nizsifra = document.getElementsByClassName("TsifraPredmeta");
    niznazivpredmeta = document.getElementsByClassName("TnazivPredmeta");
    niztippredmeta = document.getElementsByClassName("TtipPredmeta");
    nizespb = document.getElementsByClassName("TeSPB");
    nizsemestar = document.getElementsByClassName("Tsemestar");
    
    nizobrisi = document.getElementsByClassName("obrisi");
    nizizmeni = document.getElementsByClassName("izmeni");

    for(i=0; i < nizimep.length; i++)
    {
        nizobrisi[i].innerHTML="<input type='button' value='Obrisi' onclick='obrisiPredmet(\""+i+"\")'>";
        nizizmeni[i].innerHTML="<input type='button' value='Izmeni' onclick='popuniPredmet(\""+i+"\")'>";
    }

}
function loadProfesori(){

    nizidprofesora = document.getElementsByClassName("TiDProfesora");
    nizimeprofesora = document.getElementsByClassName("TimeProfesora");
    nizprezimeprofesora = document.getElementsByClassName("TprezimeProfesora");
    nizemailprofesora = document.getElementsByClassName("TemailProfesora");
    nizjmbgprofesora = document.getElementsByClassName("TjmbgProfesora");
    
    nizobrisi = document.getElementsByClassName("obrisi");
    nizizmeni = document.getElementsByClassName("izmeni");

    for(i=0; i < nizidprofesora.length; i++)
    {
        nizobrisi[i].innerHTML="<input type='button' value='Obrisi' onclick='obrisiProfesor(\""+i+"\")'>";
        nizizmeni[i].innerHTML="<input type='button' value='Izmeni' onclick='popuniProfesor(\""+i+"\")'>";
    }
    
}
function obrisiStudent(rednibroj){
    if (confirm('Jeste li sigurni da zelite da obrisete studenta?'))
        window.location.replace("http://localhost:8080/adminStudenti/deleteStudent?indeks="+nizindex[rednibroj].innerHTML);
}
function obrisiPredmet(rednibroj){
    if (confirm('Jeste li sigurni da zelite da obrisete predmeta?'))
        window.location.replace("http://localhost:8080/adminPredmeti/deletePredmet?sifra="+nizsifra[rednibroj].innerHTML);
}
function obrisiProfesor(rednibroj) {
    if (confirm('Jeste li sigurni da zelite da obrisete profesora?'))
        window.location.replace("http://localhost:8080/adminProfesori/deleteProfesor?id="+nizidprofesora[rednibroj].innerHTML);
}
function popuniStudent(i){
	document.getElementById("indeks").readOnly = true;
    document.getElementById("ime").value=nizime[i].innerHTML;
    document.getElementById("prezime").value=nizprezime[i].innerHTML;
    document.getElementById("imeOca").value=nizimeoca[i].innerHTML;
    document.getElementById("studije").value=nizstudije[i].innerHTML;
    document.getElementById("nazivSmera").value=niznazivsmera[i].innerHTML;
    document.getElementById("status").value=nizstatus[i].innerHTML;
    document.getElementById("upisanSemestar").value=nizupisansemestar[i].innerHTML;
    document.getElementById("jmbg").value=nizjmbg[i].innerHTML;
    document.getElementById("email").value=nizemail[i].innerHTML;
    document.getElementById("indeks").value=nizindex[i].innerHTML;
}
function popuniPredmet(i){
    document.getElementById("sifraPredmeta").value=nizsifra[i].innerHTML;
    document.getElementById("nazivPredmeta").value=niznazivpredmeta[i].innerHTML;
    document.getElementById("imeP").value=nizimep[i].innerHTML;
    document.getElementById("prezimeP").value=nizprezimep[i].innerHTML;
    document.getElementById("tipPredmeta").value=niztippredmeta[i].innerHTML;
    document.getElementById("eSPB").value=nizespb[i].innerHTML;
    document.getElementById("semestar").value=nizsemestar[i].innerHTML;

}
function popuniProfesor(i){
	document.getElementById("iDProfesora").readOnly = true;
    document.getElementById("iDProfesora").value=nizidprofesora[i].innerHTML;
    document.getElementById("imeProfesora").value=nizimeprofesora[i].innerHTML;
    document.getElementById("prezimeProfesora").value=nizprezimeprofesora[i].innerHTML;
    document.getElementById("jmbgProfesora").value=nizjmbgprofesora[i].innerHTML;
    document.getElementById("emailProfesora").value=nizemailprofesora[i].innerHTML;
}

var slova = /^[a-zA-Z]{1}[a-zA-Z ]*$/i
var jmbgreg = /^\d{13}$/i
var brojevi = /^\d{1,}$/i
var indeksreg=/^\d{1,}\/\d{4}$/i
var emailreg = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
var alfanumerik = /^[a-zA-Z0-9]+$/i

function dodajStudent() {
    nizindexinner=[];
    for (i=0;i<nizindex.length;i++)
         nizindexinner[i]=nizindex[i].innerHTML;
    indeks=document.getElementById("indeks").value;
    ime=document.getElementById("ime").value;
    prezime=document.getElementById("prezime").value;
    imeoca=document.getElementById("imeOca").value;
    studije=document.getElementById("studije").value;
    nazivsmera=document.getElementById("nazivSmera").value;
    status=document.getElementById("status").value;
    upisansemestar=document.getElementById("upisanSemestar").value;
    jmbg=document.getElementById("jmbg").value;
    email=document.getElementById("email").value;
    if (indeksreg.test(indeks)){
        if(nizindexinner.indexOf(indeks)===-1){
            if(slova.test(ime) && slova.test(prezime) && slova.test(imeoca)){
                if (slova.test(nazivsmera)){
                    if (brojevi.test(upisansemestar)){
                        br = 0;
                        if (studije==="OSNOVNE"){
                            if(upisansemestar>0 && upisansemestar<9)
                                br++;
                        }
                        else if (studije==="MASTER"){
                            if(upisansemestar>0 && upisansemestar<3)
                                br++;
                        }
                        else{
                            if (upisansemestar>0 && upisansemestar<7)
                                br++;
                        }
                        if(br!=0){
                            if (jmbgreg.test(jmbg)){
                                if(emailreg.test(email)){     

                                    window.location.replace("http://localhost:8080/adminStudenti/insertStudent?indeks="+indeks+"&ime="+ime+"&prezime="+prezime+"&imeoca="+imeoca+
                                    "&studije="+studije+"&nazivsmera="+nazivsmera+"&status="+status+"&upisansemestar="+upisansemestar+"&jmbg="+jmbg+"&email="+email);                               
                                        
                                }
                                else{
                                    alert("Niste uneli pravilan email");
                                }
                            }
                            else{
                                alert("Niste uneli pravilan JMBG");
                            }
                        }
                        else{
                            alert("Niste uneli pravilan upisan semestar");    
                        }
                    }
                    else{
                        alert("Niste uneli pravilan upisan semestar");
                    }
                }
                else{
                    alert("Niste pravilno uneli naziv smera");
                }
            }
            else{
                alert("Ime/Prezime/Ime oca moraju da sadrze samo slova i razmake");
            }
        }
        else{
            alert("Uneti indeks vec postoji");
        }
    }
    else{
        alert("Niste uneli pravilan indeks");
    }

    
}
function dodajPredmet() {
    nizsifrainner=[];
    for (i=0;i<nizsifra.length;i++)
        nizsifrainner[i]=nizsifra[i].innerHTML;
    sifrapredmeta=document.getElementById("sifraPredmeta").value;
    nazivpredmeta=document.getElementById("nazivPredmeta").value;
    imeprofesora=document.getElementById("imeP").value;
    prezimeprofesora=document.getElementById("prezimeP").value;
    tippredmeta=document.getElementById("tipPredmeta").value;
    espb=document.getElementById("eSPB").value;
    semestar=document.getElementById("semestar").value;
    
    if (alfanumerik.test(sifrapredmeta)){               
        if (nizsifrainner.indexOf(sifrapredmeta)===-1){
        if (alfanumerik.test(nazivpredmeta)){
            if (slova.test(imeprofesora) && slova.test(prezimeprofesora)){
                if(brojevi.test(espb)){
                    if(brojevi.test(semestar)){
                        if(semestar>0 && semestar<9){
                            window.location.replace("http://localhost:8080/adminPredmeti/insertPredmet?sifra="+sifrapredmeta+"&naziv="+nazivpredmeta+"&imeprofesora="+
                            imeprofesora+"&prezimeprofesora="+prezimeprofesora+"&tip="+tippredmeta+"&espb="+espb+"&semestar="+semestar);
                        }
                        else{
                            alert("Semestar nije pravilno unesen");    
                        }
                    }
                    else{
                        alert("Semestar nije pravilno unesen");
                    }
                }
                else{
                    alert("ESPB nije pravilno unesen");
                }
            }
            else{
                alert("Ime/Prezime profesora mora sadrzati samo slova i razmake");
            }
        }
        else{
            alert("Naziv predmeta nije pravilno unesen");
        }
    }
    else{
        alert("Uneta sifra predmeta vec postoji");
    }
    }
    else{
        alert("Sifra predmeta mora biti alfanumericka");
    }

}
function dodajProfesor() {
    
    nizidprofesorainner=[];
    for (i=0;i<nizidprofesora.length;i++)
         nizidprofesorainner[i]=nizidprofesora[i].innerHTML;
    idprofesora=document.getElementById("iDProfesora").value;
    imeprofesora=document.getElementById("imeProfesora").value;
    prezimeprofesora=document.getElementById("prezimeProfesora").value;
    jmbgprofesora=document.getElementById("jmbgProfesora").value;
    emailprofesora=document.getElementById("emailProfesora").value;
    
    if(alfanumerik.test(idprofesora)){      
        if(nizidprofesorainner.indexOf(idprofesora)===-1){
        if (slova.test(imeprofesora) && slova.test(prezimeprofesora)){
            if(jmbgreg.test(jmbgprofesora)){
                if(emailreg.test(emailprofesora)){ 
                    window.location.replace("http://localhost:8080/adminProfesori/insertProfesor?id="+idprofesora+"&ime="+imeprofesora+"&prezime="+
    prezimeprofesora+"&jmbg="+jmbgprofesora+"&email="+emailprofesora);
                }
                else{
                    alert("Email nije pravilno unesen");
                }
            }
            else{
                alert("JMBG nije pravilno unesen");
            }
        }
        else{
            alert("Ime/Prezime profesora mora sadrzati samo slova i razmake");
        }
    }
    else{
        alert("Uneti ID vec postoji");
    }
    }
    else{
        alert("ID mora biti alfanumericki");
    }

}

function izmeniStudent() {          
    nizindexinner=[];
    for (i=0;i<nizindex.length;i++)
         nizindexinner[i]=nizindex[i].innerHTML;
    indeks=document.getElementById("indeks").value;
    ime=document.getElementById("ime").value;
    prezime=document.getElementById("prezime").value;
    imeoca=document.getElementById("imeOca").value;
    studije=document.getElementById("studije").value;
    nazivsmera=document.getElementById("nazivSmera").value;
    status=document.getElementById("status").value;
    upisansemestar=document.getElementById("upisanSemestar").value;
    jmbg=document.getElementById("jmbg").value;
    email=document.getElementById("email").value;

    if (indeksreg.test(indeks)){
        if(nizindexinner.indexOf(indeks)!==-1){
            if(slova.test(ime) && slova.test(prezime) && slova.test(imeoca)){
                if (slova.test(nazivsmera)){
                    if (brojevi.test(upisansemestar)){
                        br = 0;
                        if (studije==="OSNOVNE"){
                            if(upisansemestar>0 && upisansemestar<9)
                                br++;
                        }
                        else if (studije==="MASTER"){
                            if(upisansemestar>0 && upisansemestar<3)
                                br++;
                        }
                        else{
                            if (upisansemestar>0 && upisansemestar<7)
                                br++;
                        }
                        if(br!=0){
                            if (jmbgreg.test(jmbg)){
                                if(emailreg.test(email)){     

                                    window.location.replace("http://localhost:8080/adminStudenti/updateStudent?indeks="+indeks+"&ime="+ime+"&prezime="+prezime+"&imeoca="+imeoca+
                                    "&studije="+studije+"&nazivsmera="+nazivsmera+"&status="+status+"&upisansemestar="+upisansemestar+"&jmbg="+jmbg+"&email="+email);                               
                                        
                                }
                                else{
                                    alert("Niste uneli pravilan email");
                                }
                            }
                            else{
                                alert("Niste uneli pravilan JMBG");
                            }
                        }
                        else{
                            alert("Niste uneli pravilan upisan semestar");    
                        }
                    }
                    else{
                        alert("Niste uneli pravilan upisan semestar");
                    }
                }
                else{
                    alert("Niste pravilno uneli naziv smera");
                }
            }
            else{
                alert("Ime/Prezime/Ime oca moraju da sadrze samo slova i razmake");
            }
        }
        else{
            alert("Uneti indeks ne postoji");
        }
    }
    else{
        alert("Niste uneli pravilan indeks");
    }

}
function izmeniPredmet() {
    nizsifrainner=[];
    for (i=0;i<nizsifra.length;i++)
        nizsifrainner[i]=nizsifra[i].innerHTML;
    sifrapredmeta=document.getElementById("sifraPredmeta").value;
    nazivpredmeta=document.getElementById("nazivPredmeta").value;
    imeprofesora=document.getElementById("imeP").value;
    prezimeprofesora=document.getElementById("prezimeP").value;
    tippredmeta=document.getElementById("tipPredmeta").value;
    espb=document.getElementById("eSPB").value;
    semestar=document.getElementById("semestar").value;


    if (alfanumerik.test(sifrapredmeta)){               
        if (nizsifrainner.indexOf(sifrapredmeta)!==-1){
        if (alfanumerik.test(nazivpredmeta)){
            if (slova.test(imeprofesora) && slova.test(prezimeprofesora)){
                if(brojevi.test(espb)){
                    if(brojevi.test(semestar)){
                        if(semestar>0 && semestar<9){
                            window.location.replace("http://localhost:8080/adminPredmeti/updatePredmet?sifra="+sifrapredmeta+"&naziv="+nazivpredmeta+"&imeprofesora="+
                            imeprofesora+"&prezimeprofesora="+prezimeprofesora+"&tip="+tippredmeta+"&espb="+espb+"&semestar="+semestar);
                        }
                        else{
                            alert("Semestar nije pravilno unesen");    
                        }
                    }
                    else{
                        alert("Semestar nije pravilno unesen");
                    }
                }
                else{
                    alert("ESPB nije pravilno unesen");
                }
            }
            else{
                alert("Ime/Prezime profesora mora sadrzati samo slova i razmake");
            }
        }
        else{
            alert("Naziv predmeta nije pravilno unesen");
        }
    }
    else{
        alert("Uneta sifra predmeta ne postoji");
    }
    }
    else{
        alert("Sifra predmeta mora biti alfanumericka");
    }

}
function izmeniProfesor() {
    nizidprofesorainner=[];
    for (i=0;i<nizidprofesora.length;i++)
         nizidprofesorainner[i]=nizidprofesora[i].innerHTML;
    idprofesora=document.getElementById("iDProfesora").value;
    imeprofesora=document.getElementById("imeProfesora").value;
    prezimeprofesora=document.getElementById("prezimeProfesora").value;
    jmbgprofesora=document.getElementById("jmbgProfesora").value;
    emailprofesora=document.getElementById("emailProfesora").value;
    

    if(alfanumerik.test(idprofesora)){      
        if(nizidprofesorainner.indexOf(idprofesora)!==-1){
        if (slova.test(imeprofesora) && slova.test(prezimeprofesora)){
            if(jmbgreg.test(jmbgprofesora)){
                if(emailreg.test(emailprofesora)){ 
                    window.location.replace("http://localhost:8080/adminProfesori/updateProfesor?id="+idprofesora+"&ime="+imeprofesora+"&prezime="+
    prezimeprofesora+"&jmbg="+jmbgprofesora+"&email="+emailprofesora);
                }
                else{
                    alert("Email nije pravilno unesen");
                }
            }
            else{
                alert("JMBG nije pravilno unesen");
            }
        }
        else{
            alert("Ime/Prezime profesora mora sadrzati samo slova i razmake");
        }
    }
    else{
        alert("Uneti ID ne postoji");
    }
    }
    else{
        alert("ID mora biti alfanumericki");
    }
}
function doublefilter(){
    filterr1 = document.getElementById("pretraga1").value.toUpperCase();
    filterr2 = document.getElementById("pretraga2").value.toUpperCase();
    tr = document.getElementsByTagName("tr");
    pocemu1 = document.getElementById("opcije1").value;
    pocemu2 = document.getElementById("opcije2").value;

    if (pocemu1 === "Iimeiprezime") {
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            td2 = tr[i].getElementsByTagName("td")[2];
            if (td && td2) {
                txtValue = td.textContent || td.innerText;
                txtValue2 = td2.textContent || td2.innerText;
                if (txtValue.toUpperCase().indexOf(filterr1) > -1 || txtValue2.toUpperCase().indexOf(filterr1) > -1) {
                    td3 = tr[i].getElementsByTagName("td")[pocemu2];
                    if (td3) {
                        txtValue3 = td3.textContent || td3.innerText;
                        if (txtValue3.toUpperCase().indexOf(filterr2) > -1) {
                            tr[i].style.display = "";
                        }
                        else{
                            tr[i].style.display = "none";
                        }
                    }

                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
    else {
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[pocemu1];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filterr1) > -1) {

                    td2 = tr[i].getElementsByTagName("td")[pocemu2];
                    if (td2) {
                        txtValue2 = td2.textContent || td2.innerText;
                        if (txtValue2.toUpperCase().indexOf(filterr2) > -1)
                            tr[i].style.display = "";
                        else
                            tr[i].style.display = "none";
                    }

                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }



}
function loadIspitiAdmin(){
    sifraPredmeta = document.getElementsByClassName("sifra");
    indeks = document.getElementsByClassName("indeks");
    ispitniRok = document.getElementsByClassName("ispitniRok");

    dugme = document.getElementsByClassName("ponisti");
    for(i=0; i < sifraPredmeta.length; i++)
    {
        dugme[i].innerHTML="<input value='PONISTI OCENU' type='button' onclick='ponistiOcenu(\""+i+"\")'>";            
    } 

}
function ponistiOcenu(rednibroj){

    if (confirm('Jeste li sigurni da zelite da ponistite ocenu?')){

    window.location.replace("http://localhost:8080/adminIspiti/deletePolozeni?sifraPredmeta="+sifraPredmeta[rednibroj].innerHTML+
    "&indeks="+indeks[rednibroj].innerHTML+"&ispitniRok="+ispitniRok[rednibroj].innerHTML);
    }
}

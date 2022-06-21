
//------------------------------------------------
function filter(){

    filterr = document.getElementById("pretraga").value.toUpperCase();
    pocemu = document.getElementById("opcije").value;
    tr = document.getElementsByTagName("tr");

    if(pocemu==="Simeiprezime"){
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            td2 = tr[i].getElementsByTagName("td")[1];
            if (td && td2) {
              txtValue = td.textContent || td.innerText;
              txtValue2 = td2.textContent || td2.innerText;
              if (txtValue.toUpperCase().indexOf(filterr) > -1 || txtValue2.toUpperCase().indexOf(filterr) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }
    }
    else if(pocemu==="Iimeiprezime"){
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            td2 = tr[i].getElementsByTagName("td")[2];
            if (td && td2) {
              txtValue = td.textContent || td.innerText;
              txtValue2 = td2.textContent || td2.innerText;
              if (txtValue.toUpperCase().indexOf(filterr) > -1 || txtValue2.toUpperCase().indexOf(filterr) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }
    }
    else if(pocemu==="Pimeiprezime"){
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            td2 = tr[i].getElementsByTagName("td")[3];
            if (td && td2) {
              txtValue = td.textContent || td.innerText;
              txtValue2 = td2.textContent || td2.innerText;
              if (txtValue.toUpperCase().indexOf(filterr) > -1 || txtValue2.toUpperCase().indexOf(filterr) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }
    }
    else if (pocemu==="PROimeiprezime"){
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[1];
            td2 = tr[i].getElementsByTagName("td")[2];
            if (td && td2) {
              txtValue = td.textContent || td.innerText;
              txtValue2 = td2.textContent || td2.innerText;
              if (txtValue.toUpperCase().indexOf(filterr) > -1 || txtValue2.toUpperCase().indexOf(filterr) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }
    }
    else{
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[pocemu];
            if (td) {
              txtValue = td.textContent || td.innerText;
              if (txtValue.toUpperCase().indexOf(filterr) > -1) {
                tr[i].style.display = "";
              } else {
                tr[i].style.display = "none";
              }
            }
          }
    }
    obojiVrste();
}

function obojiVrste(){
    rows = document.getElementsByTagName("tr");
    vidljivi = [];
    for (i=0; i<rows.length; i++){
        if (window.getComputedStyle(rows[i]).display !== "none") {
            vidljivi[vidljivi.length] = rows[i];
        }
    }
    for (i=1; i<=vidljivi.length; i++){
        if (i%2 === 0){
            vidljivi[i].style.backgroundColor = "rgb(223, 221, 221)";
        }
        else{
            vidljivi[i].style.backgroundColor = "#FFF";
        }
    }
}
function ajaxFun(tf, te){
  var tElem = eval("document." + tf + "." + te)
  var ajaxReq;
  try { // Firefox, Opera
    ajaxReq = new XMLHttpRequest();
    }
  catch (e) { // older IEs
    try{
      ajaxReq = new ActiveXObject("Msxml2.XMLHTTP");
      }
    catch (e) {
      try{ // still older IEs
        ajaxReq = new ActiveXObject("Microsoft.XMLHTTP");
        }
      catch (e) {
        alert("Your browser does not support Ajax!");
        return false;
        }
      }
    }
  ajaxReq.open("GET", "time.jsp");
  ajaxReq.send(null);
  ajaxReq.onreadystatechange = function() {
    if(ajaxReq.readyState == 4) {
      tElem.value = ajaxReq.responseText;
      }
    }
  }

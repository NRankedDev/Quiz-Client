<html>
    <head>
        <title>Quiz - Client</title>
        <meta charset="utf-8" />
        <style>
            #content {
                width: 1000px;
                margin: 0px auto;
            }
        </style>
    </head>
    <body>
        <div id="content">
            <div id="login" style="display: block;">
                <h1>Quiz - Client</h1>

                <table>
                    <tr><td>E-Mail:</td><td><input id="email" type="email" /></td></tr> 
                    <tr><td>Passwort:</td><td><input id="pass" type="password" /></td></tr>
                </table>
                
                <button id="login" onclick="login()">Login</button>
            </div>
            
            <div id="applet-view" style="display: none;">
                    
            </div>
            
            <script type="text/javascript" src="md5.js"></script>
            <script type="text/javascript">
                /* Simple hash code for password */
                String.prototype.hashCode = function(){
                    var hash = 0;
                    if (this.length == 0) return hash;
                    for (i = 0; i < this.length; i++) {
                        char = this.charCodeAt(i);
                        hash = ((hash<<5)-hash)+char;
                        hash = hash & hash;
                    }
                    return hash;
                }
                
                function login() {
                    // document.getElementById("login").style.display = "none";
                    // document.getElementById("applet-view").style.display = "block";
                    
                    console.log(MD5(document.getElementById("pass").value));
                }
            </script>
        </div>
    </body>
</html>
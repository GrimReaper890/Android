<?php 
 
 print_r($_GET["hub_challenge"]);
 file_put_contents("fb.txt",file_get_contents("php://input"));
 ?>
<?php 
 
//  print_r($_GET["hub_challenge"]);
 file_put_contents("fb.txt",file_get_contents("php://input"));
 $fb = file_get_contents("fb.txt");

 $fb=json_decode($fb);
 $rid= $fb->entry[0]->messaging[0]->sender->id;
echo ($rid);
$token ="EAAGForZBCDjUBABxgkSyRQEpimiElQRNUZBKDo9zp3S3o6DDavqqqwEFcToV5DOKyLplOhVRWdkfZB9Nlrm1RqOWZAT8lAMuJAYjnnhDM9rQnQDqm59JZBtBk8hU88rCBxhpXtYebyPVE771uB7PG9xX1y9ZCZB3KyRhR4Alqd9QQZDZD";

$data = array(
    'recipient' => array('id'=>"$rid"),
    'message' => array('text'=>"oh Hello there!")
);
$options = array(
    'http'=> array(
            'method'=> 'POST',
             'content' => json_encode($data),
             'header'=> "Content-Type: application/json\n"
    )
);
$context = stream_context_create($options);
file_get_contents("https://graph.facebook.com/v2.6/me/messages?access_token=$token",false,$context);
 ?>
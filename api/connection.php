<?php
$host		= "localhost";
$user		= "root";
$pass		= "209999!1";
$dbname	= "app_wisata-batam";

$db = new mysqli($host, $user, $pass, $dbname);
if (get_magic_quotes_gpc()) {
    $process = array(&$_GET, &$_POST, &$_COOKIE, &$_REQUEST);
    while (list($key, $val) = each($process)) {
        foreach ($val as $k => $v) {
            unset($process[$key][$k]);
            if (is_array($v)) {
                $process[$key][stripslashes($k)] = $v;
                $process[] = &$process[$key][stripslashes($k)];
            } else {
                $process[$key][stripslashes($k)] = stripslashes($v);
            }
        }
    }
    unset($process);
}
if($db->connect_errno){
	echo $db->connect_error;
	die('Maaf, ada kesalahan teknis. Database tidak terkoneksi');
}
?>

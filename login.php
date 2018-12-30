<?php
session_start();
include("koneksi.php");
//handling parameter
if(empty($_POST)){
	//kembali ke form login
	header("location:index.php?login=kosong");
}
else{
	//tangkap parameternya
	$username = $_POST['username'];
	$password = $_POST['password'];
	//query
	$sql = "select * from tbl_admin where username = '$username' and password = '$password'";
	$eksekusi = mysqli_query($conn, $sql);
	$row = mysqli_fetch_array($eksekusi);

	//deteksi jumlah row
	$jum_row = mysqli_num_rows($eksekusi);
	if($jum_row == 0){
		//kembali ke form login
		header("location:index.php?login=salah");
	}
	else{
		//login berhasil
		$_SESSION['nama'] = $row['nama'];
		header("location:home.php");
	}
}
?>
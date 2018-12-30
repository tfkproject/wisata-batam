<?php
include("koneksi.php");
if(isset($_GET)){
	$id = $_GET['id_wisata'];
	
	$sql1 = "select foto_cover from tbl_wisata where id_wisata = '$id'";
	$eksekusi1 = mysqli_query($conn, $sql1);
	$row1 = mysqli_fetch_array($eksekusi1);
	
	$nama_file = $row1['foto_cover'];
	
	$lokasi_img = "images/wisata/".$nama_file;
	
	
	$sql2 = "DELETE FROM `tbl_wisata` WHERE `id_wisata` = '$id'";
	$eksekusi2 = mysqli_query($conn, $sql2);
	if($eksekusi2){
	    //hapus file
	    unlink($nama_file);
		?>
		<script>
			window.location = "home.php";
		</script>
		<?php
	}
	else{
		?>
		<script>
			alert('Data gagal dihapus');
			history.back(-1);
		</script>
		<?php
	}
}
else{
	?>
	<script>
		alert('Maaf, terjadi error.');
		history.back(-1);
	</script>
	<?php
}
?>
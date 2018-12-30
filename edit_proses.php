<?php
include("koneksi.php");
if(isset($_POST)){
	$id = $_POST['id'];
	$nama = $_POST['nama'];
	$gambar_sblm = $_POST['gambar_sblm'];
	$gambar = $_FILES['gambar']['name'];
	$lokasi = $_POST['lokasi'];
	$deskripsi = $_POST['deskripsi'];
	$lat = $_POST['latitude'];
	$long = $_POST['longitude'];
	
	if($gambar == null){
	    $foto = $gambar_sblm;
	}else{
	    $foto = $gambar;
	}
	
   $sql ="UPDATE `tbl_wisata` SET 
        	`nama_objek`         = '$nama', 
        	`foto_cover`    = '$foto', 
        	`lokasi`        = '$lokasi',
        	`deskripsi`     = '$deskripsi',
        	`latitude`      = '$lat', 
        	`longitude`     = '$long'
         where `id_wisata` = '$id'";
   
	$eksekusi = mysqli_query($conn, $sql);
	      
	move_uploaded_file($_FILES['gambar']['tmp_name'], "images/wisata/".$foto);
	if($eksekusi){
		?>
		<script>
			window.location = "home.php";
		</script>
		<?php
	}
	else{
		?>
		<script>
			alert('Data gagal disimpan, mohon koreksi ulang.');
			history.back(-1);
		</script>
		<?php
	}
}
else{
	?>
	<script>
		alert('Mohon isi semua field');
		history.back(-1);
	</script>
	<?php
}
?>
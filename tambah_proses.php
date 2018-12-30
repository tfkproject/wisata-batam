<?php
include("koneksi.php");

if(isset($_POST)){
    $nama = $_POST['nama'];
	$foto = $_FILES['gambar']['name'];
	$lokasi = $_POST['lokasi'];
	$deskripsi = $_POST['deskripsi'];
	$lat = $_POST['latitude'];
	$long = $_POST['longitude'];
	
	
    $sql ="INSERT INTO `tbl_wisata` (`id_wisata`, `nama_objek`, `foto_cover`, `lokasi`, `deskripsi`, `latitude`, `longitude`) VALUES (NULL, '$nama', '$foto', '$lokasi', '$deskripsi', '$lat', '$long')";
   
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
<?php
include("koneksi.php");
if(isset($_POST)){
	$id = $_POST['id_profil'];
	$konten = $_POST['konten'];
		
   $sql ="UPDATE `tbl_profil` SET 
        	`konten`    = '$konten'
         where `id_profil` = '$id'";
   
	$eksekusi = mysqli_query($conn, $sql);
	 
	if($eksekusi){
		?>
		<script>
			window.location = "profil.php";
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
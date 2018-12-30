<?php
include("koneksi.php");

if(isset($_POST)){
    $tanggal = $_POST['tanggal'];
    $event = $_POST['event'];
	
	
    $sql ="INSERT INTO `tbl_event` (`id_event`, `tanggal`, `event`) VALUES (NULL, '$tanggal', '$event')";
   
	$eksekusi = mysqli_query($conn, $sql);
	      
	if($eksekusi){
		?>
		<script>
			window.location = "event.php";
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
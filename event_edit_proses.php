<?php
include("koneksi.php");
if(isset($_POST)){
	$id = $_POST['id_event'];
	$tanggal = $_POST['tanggal'];
	$event = $_POST['event'];
		
   $sql ="UPDATE `tbl_event` SET 
        	`tanggal`         = '$tanggal', 
        	`event`    = '$event'
         where `id_event` = '$id'";
   
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
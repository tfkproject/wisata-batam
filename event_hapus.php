<?php
include("koneksi.php");
if(isset($_GET)){
	$id = $_GET['id'];
	
	$sql1 = "delete from tbl_event where id_event = '$id'";
	$eksekusi = mysqli_query($conn, $sql1);
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
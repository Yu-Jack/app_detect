<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Security</title>
	<link rel="stylesheet" href="{{ URL::asset('/css/bootstrap.css')}}">
	<link rel="stylesheet" href="{{ URL::asset('/css/jquery.fileupload.css')}}">
	
	<script src="{{ URL::asset('js/jquery.js') }}"></script>
	<script src="{{ URL::asset('js/jquery.ui.widget.js') }}"></script>
	<script src="{{ URL::asset('js/jquery.iframe-transport.js') }}"></script>
	<script src="{{ URL::asset('js/jquery.fileupload.js') }}"></script>
	<style>
		html, body{
			height: 100%;
		}
	</style>
</head>
<body>
	@yield('content')
</body>
</html>
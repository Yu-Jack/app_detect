@extends('head')

@section('content')
	<style>
		.black{
			height: 100%;
			padding:0px;
		}
		.background{
			position: fixed;
			height: 100%;
			width: 100%;
			background: url('/background.jpg') center center;
			background-size:cover;
			opacity: 0.2;
		}
	</style>
	<div class="container-fluid black">
		<div class="background"></div>
		<div class="row" style="margin:0px;">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1" style="margin-top:20px;">
				<h2 class="text-center" style="word-break:break-all;">{{ $filename }}</h2>
				<pre>{{{$content}}}</pre>
			</div>
	    </div>
	</div>
	
@stop
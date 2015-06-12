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
			background: url('background.jpg') center center;
			background-size:cover;
			opacity: 0.2;
		}
		.table{
			background-color: #eee;
			margin:25px 0px;
		}
	</style>
	<div class="container-fluid black">
		<div class="background"></div>
		<div class="row" style="margin:0px;">
			<div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2" style="margin-top:20px;">
				<h2 class="text-center" style="word-break:break-all;">{{ $filename }}</h2>
				<table class="table table-bordered table-hover">
					<tr class="info">
						<td><h1>Permission</h1></td>
					</tr>
					@foreach ( $datas as $item)
						<tr>
							<td>{{ $item }}</td>
						</tr>
					@endforeach					
				</table>
				<div style="height:600px;overflow-y:auto;margin-bottom:50px;">
					<table class="table table-bordered table-hover" style="margin:0px;">
						<tr class="info">
							<td><h1>Encapsulating</h1></td>
						</tr>
						@foreach ( $javafiles as $javafile)
							<tr>
								<td>
									<a href="/view/{{ substr($javafile,31) }}" target="_blank">{{ substr($javafile,31) }}</a>
								</td>
							</tr>
						@endforeach
					</table>
				</div>
			</div>
	    </div>
	</div>
	
@stop
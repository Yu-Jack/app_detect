<?php namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Session;
class MainController extends Controller {

	/*
	|--------------------------------------------------------------------------
	| Main Controller
	|--------------------------------------------------------------------------
	|
	| This controller renders the "marketing page" for the application and
	| is configured to only allow guests. Like most of the other sample
	| controllers, you are free to modify or remove it as you desire.
	|
	*/

	/**
	 * Create a new controller instance.
	 *
	 * @return void
	 */
	public function __construct()
	{
		$this->middleware('guest');
	}

	/**
	 * Show the application welcome screen to the user.
	 *
	 * @return Response
	 */
	public function index()
	{
		return view('index');
	}

	// run bash with apk file
	public function result(Request $request)
	{
		// $ls = system('adb version', $return_var);
		// $ls = system('echo test', $return_var);
		// shell_exec('adb shell');
		// $ls = shell_exec('ls');
		// $ls = system('/opt/mobisec/Android/sdk/platform-tools/adb shell ls', $return_var);
		// exec('sh /home/mobisec/test.sh', $output, $return_var);
		// $output = shell_exec('sh /home/mobisec/test.sh');
		// $output = @system('sh /home/mobisec/test.sh', $return_var);

		// $request->session()->flush();
		// dd();
		// $filename = $request->session();
		// dd($filename->get('filename'));
		
		

		$file = Session::get('filename');;
		$dexfile = str_replace('.apk', '_dex2jar.jar', $file);
		$foldername = str_replace('.apk', '', $file);
		exec('sh /var/www/app_detect/public/sh/permission.sh /var/www/app_detect/storage/apk/'. $file , $output, $return_var);

		// deal with dex2jar & javadecompiler
		exec('sh /var/www/app_detect/public/sh/dex.sh /var/www/app_detect/storage/apk/'. $file . ' /var/www/app_detect/storage/apk/'. $dexfile . ' /var/www/app_detect/storage/apk/'. $foldername , $output1, $return_var1);
		$start_path = '/var/www/app_detect/storage/apk/'. $foldername .'/*';

		$java_files = [];
		function parseFolder($start_path, $java_files ){

			$pattern = '/java/';
			$entry_size = count(glob($start_path));
			$entry = glob($start_path);

			$result = [];
			for ( $i = 0 ; $i < $entry_size ; $i++ ){
				if(preg_match($pattern, $entry[$i]) == 1){
					return array_merge($java_files, glob($start_path));
				}else{
					// return array_merge($java_files, parseFolder($entry[$i]."/*", $java_files));
					$result = array_merge($result, parseFolder($entry[$i]."/*", $java_files));
				}
			}
			return $result;
		}

		$java_files = parseFolder($start_path, $java_files);

		$explain = 'https://github.com/Yu-Jack/app_detect.git';
		// while(glob($MainController) != null){
		// 	if(count(glob($temp_path)) > 3){
		// 		$path = $temp_path;	
		// 	}
		// 	$temp_path = glob($temp_path)[0]."/*";
			
		// }
		// $java_files = glob($path);
		// exec('dex2jar /var/www/app_detect/public/storage/apk/' . $file, $output1, $return_var1);
		// exec('dex2jar /var/www/app_detect/public/storage/apk/' . $file, $output1, $return_var1);
		// dd($output);
		// exec('/home/mobisec/test.sh', $output, $return_var);
		// system('/opt/mobisec/Android/sdk/platform-tools/adb install /home/mobisec/Downloads/AndroidLabs11.apk', $return_var);
		// $output = system('/opt/mobisec/Android/sdk/build-tools/22.0.1/aapt dump badging /home/mobisec/Downloads/AndroidLabs11.apk', $return_var);
		// exec('/opt/mobisec/Android/sdk/build-tools/22.0.1/aapt dump badging /home/mobisec/Downloads/AndroidLabs11.apk', $datas, $return_var);
		// dd($datas);
		
		return view('detail')->with('datas', $output)->with('filename', $file)->with('javafiles',$java_files);
		// return view('detail');
		// return view('index');
	}

	public function upload(Request $request)
	{
		$file = $request->file('apk');
		if( $file->isValid()){
			$file_name = $file->getClientOriginalName();
			$file->move('/var/www/app_detect/storage/apk', $file_name);
			// $request->flush();
			// $request->session(['filename' => $file_name]);
			// session(['filename' => $file_name]);
			Session::flush();
			Session::put('filename',$file_name);
			// $request->session('filename',$file_name);
			// Session::put('filename', $file_name);
			// Session::put('filename', 'tsetsetsets');
			// dd(Session::get('filename'));
			return 'success';
		}else{
			return 'fail';
		}
	}

	public function view($filename)
	{
		$file = '/var/www/app_detect/storage/apk/' . $filename;
		$content = file_get_contents($file);
		// dd($content);
		return view('content')->with('content', $content)->with('filename', $filename);
	}

}

<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\User;
use App\Http\Requests;
use JWTAuth;
use DB;
use Tymon\JWTAuth\Exceptions\JWTException;
class AuthenticateController extends Controller
{



   public function __construct()
{

$this->middleware('jwt.auth',['except'=>['authenticate','storeUser']]);

}


    public function index()
    {
        return "index broth";    
    }


        public function authenticate(Request $request)
    {
        // grab credentials from the request
        $credentials = $request->only('email', 'password');

        try {
            // attempt to verify the credentials and create a token for the user
            if (! $token = JWTAuth::attempt($credentials)) {
                return response()->json(['error' => 'invalid_credentials'], 401);
            }
        } catch (JWTException $e) {
            // something went wrong whilst attempting to encode the token
            return response()->json(['error' => 'could_not_create_token'], 500);
        }

 $email= $request->email;
$user = DB::table('users')->where('email', $email)->first();
        // all good so return the token
        return response()->json(compact('token','user'));
    }





        public function storeUser(Request $request)
    {
    	$user= new User;
    	$user->name = $request->name;
        

        
        $user->email = $request->email;
       
        $user->password =bcrypt($request->password);
        $user->save();

        return response()->json(compact('user'));


    }





}

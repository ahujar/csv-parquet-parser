# csv-parquet-parser
Transforms a CSV to Parquet Using Apache Avro Parquet Writer and Univocity Csv Parsers

AWSCredentials are needed to be set in the application.properties

Sample Output :

21/05/06 21:48:04 INFO parser.ParseServiceClient: Downloading zip file from bucket candidate-19-s3-bucket ..  
21/05/06 21:48:07 INFO parser.ParseServiceClient: Downloaded zip.  
21/05/06 21:48:07 INFO parser.ParseServiceClient: Parsing AirbnbListing  
21/05/06 21:48:07 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable  
21/05/06 21:48:07 INFO compress.CodecPool: Got brand-new compressor  
21/05/06 21:48:10 INFO parser.ParseServiceClient: Created AirbnbListing.parquet   
21/05/06 21:48:10 INFO parser.ParseServiceClient: Uploading AirbnbListing.parquet to bucket candidate-19-s3-bucket ..  
21/05/06 21:48:10 INFO parser.ParseServiceClient: Uploaded eTag 8e9125a25fc26a463c0d3e8cfb7cc42f  
21/05/06 21:48:10 INFO parser.ParseServiceClient: Parsing ausnews  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Created ausnews.parquet  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Uploading ausnews.parquet to bucket candidate-19-s3-bucket ..  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Uploaded eTag 20aef1ec71465dafd6286cc856b82239  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Parsing netflix_titles  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Created netflix_titles.parquet  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Uploading netflix_titles.parquet to bucket candidate-19-s3-bucket ..  
21/05/06 21:48:12 INFO parser.ParseServiceClient: Uploaded eTag df646b6fb19a423754666e15613aec36  


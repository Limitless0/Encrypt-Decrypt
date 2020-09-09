# Encrypt-Decrypt
A hyperskill project. You have the option of two methods, Unicode cypher or text only cypher, choosing between the two with command line arguments.
Command line arguments that are accepted are (include hyphen, exclude comma):
-in, path of input file
-data, data to be encrypted/decrypted, exclusive with -in
-out, output file path
-mode, "enc" or "dec" for encryption or decryption, defaults to encryption
-key, integer key for cypher, default 0
-alg, "unicode" or "shift", default is shift (text only)

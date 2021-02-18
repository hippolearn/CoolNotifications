( cd usr/lib ; rm -rf libtasn1.so )
( cd usr/lib ; ln -sf libtasn1.so.6.6.0 libtasn1.so )
( cd usr/lib ; rm -rf libtasn1.so.6 )
( cd usr/lib ; ln -sf libtasn1.so.6.6.0 libtasn1.so.6 )

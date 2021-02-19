( cd usr/lib ; rm -rf libidn2.so )
( cd usr/lib ; ln -sf libidn2.so.0.3.7 libidn2.so )
( cd usr/lib ; rm -rf libidn2.so.0 )
( cd usr/lib ; ln -sf libidn2.so.0.3.7 libidn2.so.0 )

( cd usr/lib ; rm -rf libp11-kit.so )
( cd usr/lib ; ln -sf libp11-kit.so.0.3.0 libp11-kit.so )
( cd usr/lib ; rm -rf libp11-kit.so.0 )
( cd usr/lib ; ln -sf libp11-kit.so.0.3.0 libp11-kit.so.0 )
( cd usr/lib ; rm -rf p11-kit-proxy.so )
( cd usr/lib ; ln -sf libp11-kit.so.0.3.0 p11-kit-proxy.so )
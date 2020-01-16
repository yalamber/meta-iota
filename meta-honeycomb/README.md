# meta-honeycomb

![meta-honeycomb](https://github.com/bernardoaraujor/meta-iota/raw/master/meta-iota.png  "meta-honeycomb")

[IOTA](https://www.iota.org/) is a revolutionary new transactional settlement and data transfer layer for the Internet of Things. It’s based on a new distributed ledger, the Tangle, which gets rid off the inefficiencies of current Blockchain designs and introduces a new way of reaching consensus in a decentralized peer-to-peer system. For the first time ever, through IOTA people can transfer money without any fees. This means that even infinitesimally small nanopayments can be made through IOTA.

IOTA is the missing puzzle piece for the Machine Economy to fully emerge and reach its desired potential. We envision IOTA to be the public, permissionless backbone for the **Internet of Things** (**IoT**) that enables true interoperability between all devices.

The **meta-honeycomb** OpenEmbedded Layer provides configurations and recipes for **HoneyComb**, a Linux Distribution tailored for IOTA nodes, clients and Tangle related tools.

Any collaborations (issues, patches, pull requests, suggestions) are more than welcome: <bernardoaraujor@gmail.com>

---
## Dependencies

The meta-honeycomb layer depends on:

	URI: git://git.openembedded.org/openembedded-core
	layers: meta
	branch: warrior, thud, zeus

	URI: git://git.openembedded.org/meta-openembedded
	layers: meta-oe
	branch: warrior, thud, zeus

        URI: git://github.com/bernardoaraujor/meta-iota
        layers: meta-iota
        branch: master
	
---
## License

meta-honeycomb is released under the [MIT License](https://github.com/bernardoaraujor/meta-honeycomb/blob/master/COPYING.MIT).


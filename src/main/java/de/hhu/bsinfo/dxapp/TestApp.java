package de.hhu.bsinfo.dxapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import de.hhu.bsinfo.dxmem.core.Context;
import de.hhu.bsinfo.dxmem.data.AbstractChunk;
import de.hhu.bsinfo.dxmem.data.ChunkDummy;
import de.hhu.bsinfo.dxmem.operations.Put;
import de.hhu.bsinfo.dxram.DXRAM;
import de.hhu.bsinfo.dxram.app.AbstractApplication;
import de.hhu.bsinfo.dxram.boot.BootService;
import de.hhu.bsinfo.dxram.chunk.ChunkLocalService;
import de.hhu.bsinfo.dxram.chunk.ChunkService;
import de.hhu.bsinfo.dxram.chunk.bench.ChunkTaskUtils;
import de.hhu.bsinfo.dxram.chunk.data.ChunkAnon;
import de.hhu.bsinfo.dxram.chunk.operation.Create;
import de.hhu.bsinfo.dxram.engine.DXRAMVersion;
import de.hhu.bsinfo.dxram.generated.BuildConfig;
import de.hhu.bsinfo.dxutils.NodeID;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

/**
 * "Hello world" example DXRAM application
 *
 * @author Stefan Nothaas, stefan.nothaas@hhu.de, 17.05.17
 */
public class TestApp extends AbstractApplication {
    @Override
    public DXRAMVersion getBuiltAgainstVersion() {
        return BuildConfig.DXRAM_VERSION;
    }

    @Override
    public String getApplicationName() {
        return "TestApp";
    }

    @Override
    public void main(final String[] p_args) {
        BootService bootService = getService(BootService.class);
        TestObject Test = new TestObject("TEST", 10);
        ChunkLocalService chunkLocalservice = getService(ChunkLocalService.class);
        //ChunkService chunkService = getService(ChunkService.class);
        Test.setID(1);
        System.out.println(Test.getID());
        //long cid = create.create(100);
        //ChunkId
        int ret = chunkLocalservice.createLocal().create(Test);
        //short remotePeer =
        //int ret = (int) chunkService.create().create(Test);

        System.out.println("Hello, I am application " + getApplicationName() + " on a peer and my node id is " +
                NodeID.toHexString(bootService.getNodeID()) + " with " + p_args.length + " cmd args: " +
                Arrays.toString(p_args) + "ID" + Test.getID() + "State" + Test.getState());

        System.out.println("ret " + ret + "\nIDvalid " + Test.isIDValid() + "\nStateOk " + Test.isStateOk() +
                "\nget " + chunkLocalservice.getLocal().get() + "\nIDvalid " + Test.isIDValid());

    }

    @Override
    public void signalShutdown() {
        // Interrupt any flow of your application and make sure it shuts down.
        // Do not block here or wait for something to shut down. Shutting down of your application
        // must be execute asynchronously
    }
}

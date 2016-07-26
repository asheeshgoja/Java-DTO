using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Net.Sockets;

namespace CustomerOrderProcessing
{
    namespace Transport
    {
        internal class TcpIpChannel
        {
            TcpClient _client;
            NetworkStream _stream;

            public TcpIpChannel()
            {
                String[] args = Environment.GetCommandLineArgs();
                _client = new TcpClient( args[1], int.Parse(args[2]) );
                _stream = _client.GetStream();
            }

            public void Send(byte[] data)
            {
                _stream.Write(data, 0, data.Length);
            }

            public byte[] Recieve()
            {
                byte[] buffer = new byte[1024];
                _stream.Read(buffer, 0, buffer.Length);
                return buffer;
            }
        }
    }
}

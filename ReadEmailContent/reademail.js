(async () => {
  const MailosaurClient = require('mailosaur')

  // Available in the API tab of a server
  const apiKey = 'Co3qZhhnd356LAXs'
  const serverId = 'fsekpwtu'
  const serverDomain = 'fsekpwtu.mailosaur.net'

  const mailosaur = new MailosaurClient(apiKey)

  const criteria = {
    sentTo: 'rise-smooth@' + serverDomain
  }

  const email = await mailosaur.messages.get(serverId, criteria)

  //console.log('Subject: ${email.subject}')
  console.log('Subject:', email.subject);
  console.log('body:', email.text);
})()